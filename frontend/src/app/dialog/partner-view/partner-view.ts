import { Component, inject, OnInit, signal } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import {
    MAT_DIALOG_DATA,
    MatDialogActions,
    MatDialogContent,
    MatDialogRef
} from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import {  MatSelectModule } from '@angular/material/select';
import { ClassificationDTO, CustomerDTO, CustomerStatusDTO, TaskDetailsDTO, XRMService } from '../../generated';
import { MatTableModule } from '@angular/material/table';

@Component({
    selector: 'partner-view',
    templateUrl: 'partner-view.html',
    imports: [
        ReactiveFormsModule,
        MatFormFieldModule,
        MatInputModule,
        FormsModule,
        MatButtonModule,
        MatDialogContent,
        MatDialogActions,
        MatSelectModule,
        MatInputModule,
        FormsModule,
        MatTableModule,

    ],
})
export class PartnerViewDialog implements OnInit {


    customerStatus = Object.values(CustomerStatusDTO);
    classification = Object.values(ClassificationDTO);

    editableCustomer: CustomerDTO = {};
    readonly dialogRef = inject(MatDialogRef<PartnerViewDialog>);
    readonly data = inject<CustomerDTO>(MAT_DIALOG_DATA) as CustomerDTO;
    readonly xRMService = inject<XRMService>(XRMService);
    taskList = signal<TaskDetailsDTO[]>([]);
    displayedColumns: string[] = ['subject', 'type', 'description', 'time'];

    ngOnInit(): void {
        if (this.data.id) {
            this.xRMService.getCustomerTasks(this.data.id).subscribe({
                next: data => this.taskList.set(data),
            })
        }
    }

    close(): void {
        this.dialogRef.close();
    }

}

