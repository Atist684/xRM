import { Component, inject, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import {
    MAT_DIALOG_DATA,
    MatDialogActions,
    MatDialogContent,
    MatDialogRef
} from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatOption, MatSelectModule } from '@angular/material/select';
import { ClassificationDTO, CustomerDTO, CustomerStatusDTO, XRMService } from '../../generated';
import { PartnerService } from '../../service/partner';

@Component({
    selector: 'partner-edit',
    templateUrl: 'partner-edit.html',
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
})
export class PartnerEditDialog implements OnInit{

    customerStatus  = Object.values(CustomerStatusDTO);
    classification  = Object.values(ClassificationDTO);

    readonly dialogRef = inject(MatDialogRef<PartnerEditDialog>);
    readonly data = inject<CustomerDTO>(MAT_DIALOG_DATA);
    readonly xRMService = inject(XRMService);
    readonly partnerService = inject(PartnerService);
    
    customerForm: FormGroup = new FormGroup({
        name: new FormControl('',Validators.required),
        taxNumber: new FormControl('',[Validators.required,Validators.pattern(/^\d{8}-\d-\d{2}$/)]),
        address: new FormControl('',Validators.required),
        status: new FormControl('',Validators.required),
        classification: new FormControl('',Validators.required),
        id: new FormControl(),
    });

    ngOnInit(): void {
        if(this.data.id !== undefined && this.data.id !== null && this.data.id !== 0){
            this.customerForm.setValue(this.data);
        }
    } 

    close(): void {
        this.dialogRef.close();
    }

    update() {
        if(this.customerForm.valid){
            const customer = this.customerForm.value as CustomerDTO;
            if(customer.id !== undefined && customer.id !== null){
                this.xRMService.updateCustomer(customer).subscribe({
                    next: resp => {
                        this.partnerService.loadCustomers();
                        this.partnerService.loadTask();
                        this.dialogRef.close();
                    },
                    error: err => console.error(err)
                });                
            }else{
                this.xRMService.newCustomer(customer).subscribe({
                    next: resp => {
                        this.partnerService.loadCustomers();
                        this.partnerService.loadTask();
                        this.dialogRef.close();
                    },
                    error: err => console.error(err)
                });
            }
        }
    }
}

