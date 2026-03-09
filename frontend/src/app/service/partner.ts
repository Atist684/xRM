import { computed, inject, Injectable, signal } from '@angular/core';
import { ClassificationDTO, CustomerDTO, ReportDTO, ResponsibleDTO, TaskDTO, XRMService } from '../generated';

@Injectable({
  providedIn: 'root',
})
export class PartnerService {

  readonly xRMService = inject(XRMService);
  
  public customerData = signal<CustomerDTO[]>([])
  public filterData = signal<ClassificationDTO[]>([])
  public taskData = signal<TaskDTO[]>([])
  public reportData = signal<ReportDTO[]>([])
  public resposibleData = signal<ResponsibleDTO[]>([])

  public viewCustomerData = computed(() => {
    if (!this.filterData() || this.filterData().length === 0) {
      return this.customerData();
    }
    const filtered = this.customerData().filter(item =>
      item.classification?.some(c => this.filterData().includes(c))
    );
    return filtered;
  })
  public activeCustomerData = computed(() => {
    return this.customerData().filter(f => f.status === 'Active');
  })

  //init data
  constructor() {
    this.loadCustomers();
    this.loadTask();
    this.loadResponsible();
  }

  public loadReport() {
    this.xRMService.getReport().subscribe({
      next: data => {
        this.reportData.set(data);
      }
    });
  }

  public loadCustomers() {
    this.xRMService.getAllCustomer().subscribe({
      next: data => {
        this.customerData.set(data);
      }
    });
  }

  public loadTask() {
    this.xRMService.getAllTask().subscribe({
      next: data => {
        this.taskData.set(data);
      }
    });
  }

  public loadResponsible() {
    this.xRMService.getAllResponsibleUser().subscribe({
      next: data => {
        this.resposibleData.set(data);
      }
    });
  }

}
