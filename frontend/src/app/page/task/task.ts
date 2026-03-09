import { Component, inject } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatSelectChange, MatSelectModule } from '@angular/material/select';
import { PartnerEditDialog } from '../../dialog/partner-edit/partner-edit';
import { PartnerViewDialog } from '../../dialog/partner-view/partner-view';
import { ClassificationDTO, CustomerDTO, TaskDTO, XRMService } from '../../generated';
import { PartnerService } from '../../service/partner';
import { PageTemplate } from '../template/page-template';
import { FormsModule } from '@angular/forms';
import { MatAnchor, MatButton } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatTableModule } from '@angular/material/table';
import { TaskEditDialog } from '../../dialog/task-edit/task-edit/task-edit';

@Component({
  selector: 'app-task',
  imports: [MatTableModule, MatFormFieldModule, MatSelectModule, MatInputModule, FormsModule, MatAnchor,MatButton,MatPaginatorModule],
  templateUrl: './task.html',
  styleUrl: './task.css',
})
export class Task extends PageTemplate {

  readonly dialog = inject(MatDialog);
  readonly xRMService = inject(XRMService);
  readonly partnerService = inject(PartnerService);
  
  displayedColumns: string[] = ['subject', 'type', 'description', 'time','responsible','partner','edit'];


  edit(element: TaskDTO) {
    this.dialog.open(TaskEditDialog, {
      data: element
    });
  }

  classChanged(event: MatSelectChange<ClassificationDTO[]>){
    this.partnerService.filterData.set(event.value);
  }

  newCustomer(){
      this.dialog.open(TaskEditDialog, {
        data: {}
    });
  }
  deleteTask(element: TaskDTO){

    if(element.id !== null && element.id !== undefined && !isNaN(element.id!)){
      this.xRMService.deleteTask(Number(element.id))
      .subscribe({
        next: resp => {
          this.partnerService.loadTask();
        },
        error: err => console.error("Api error: "+err)
      });
    }
  }

  
}
