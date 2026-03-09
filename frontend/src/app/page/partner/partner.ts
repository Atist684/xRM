import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatAnchor, MatButton } from "@angular/material/button";
import { MatDialog } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSelectChange, MatSelectModule } from '@angular/material/select';
import { MatTableModule } from '@angular/material/table';
import { PartnerEditDialog } from '../../dialog/partner-edit/partner-edit';
import { PartnerViewDialog } from '../../dialog/partner-view/partner-view';
import { ClassificationDTO, CustomerDTO, XRMService } from '../../generated';
import { PartnerService } from '../../service/partner';
import { PageTemplate } from '../template/page-template';

@Component({
  selector: 'app-partner',
  imports: [MatTableModule, MatFormFieldModule, MatSelectModule, MatInputModule, FormsModule, MatAnchor,MatButton,MatPaginatorModule],
  templateUrl: './partner.html',
  styleUrl: './partner.css',
})

export class Partner extends PageTemplate{
  
  classification = Object.values(ClassificationDTO);


  readonly dialog = inject(MatDialog);
  readonly xRMService = inject(XRMService);
  readonly partnerService = inject(PartnerService);
  
  displayedColumns: string[] = ['name', 'taxNumber', 'address', 'classification','status','edit'];


  edit(element: CustomerDTO) {
    this.dialog.open(PartnerEditDialog, {
      data: element
    });
  }

    view(element: CustomerDTO) {
    this.dialog.open(PartnerViewDialog, {
      data: element
    });
  }

  classChanged(event: MatSelectChange<ClassificationDTO[]>){
    this.partnerService.filterData.set(event.value);
  }

  newCustomer(){
      this.dialog.open(PartnerEditDialog, {
        data: {}
    });
  }
  deleteCustomer(element: CustomerDTO){

    if(element.id !== null && element.id !== undefined && !isNaN(element.id!)){
      this.xRMService.deleteCustomer(Number(element.id))
      .subscribe({
        next: resp => {
          this.partnerService.loadCustomers();
          this.partnerService.loadTask();
        },
        error: err => console.error("Api error: "+err)
      });
    }
  }

}
