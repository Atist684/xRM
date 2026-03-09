import { Component, inject, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogActions, MatDialogContent, MatDialogRef } from '@angular/material/dialog';
import { ClassificationDTO, CustomerStatusDTO, TaskDTO, XRMService } from '../../../generated';
import { PartnerService } from '../../../service/partner';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatOption, MatSelectModule } from '@angular/material/select';

@Component({
  selector: 'app-task-edit-dialog',
  imports: [
        ReactiveFormsModule,
        MatFormFieldModule,
        MatInputModule,
        FormsModule,
        MatButtonModule,
        MatDialogContent,
        MatDialogActions,
        MatOption,
        MatSelectModule
    ],
  templateUrl: './task-edit.html',
  styleUrl: './task-edit.css',
})
export class TaskEditDialog implements OnInit {

    readonly dialogRef = inject(MatDialogRef<TaskEditDialog>);
    readonly data = inject<TaskDTO>(MAT_DIALOG_DATA);
    readonly xRMService = inject(XRMService);
    readonly partnerService = inject(PartnerService);

    
    customerForm: FormGroup = new FormGroup({
        subject: new FormControl('',Validators.required),
        type: new FormControl('',[Validators.required]),
        description: new FormControl('',Validators.required),
        time: new FormControl('',[Validators.required,Validators.min(1)]),
        responsible: new FormControl('',Validators.required),
        partner: new FormControl('',Validators.required),
        id: new FormControl(),
    });

    ngOnInit(): void {
        if(this.data.id !== undefined && this.data.id !== null && this.data.id !== 0){
            this.customerForm.setValue(this.data);
            this.customerForm.get("responsible")?.setValue(this.partnerService.resposibleData().find(f => f.id === this.data.responsible?.id));
             this.customerForm.get("partner")?.setValue(this.partnerService.activeCustomerData().find(f => f.id === this.data.partner?.id));
        }
    } 

    close(): void {
        this.dialogRef.close();
    }

    update() {
        if(this.customerForm.valid){
            const task = this.customerForm.value as TaskDTO;
            if(task.id !== undefined && task.id !== null && task.id !== 0){
                this.xRMService.updateTask(task).subscribe({
                    next: resp => {
                        this.dialogRef.close();
                        this.partnerService.loadTask();
                    },
                    error: err => console.error(err)
                });                
            }else{
                this.xRMService.newTask(task).subscribe({
                    next: resp => {
                        this.dialogRef.close();
                        this.partnerService.loadTask();
                    },
                    error: err => console.error(err)
                });
            }
        }
    }
}
