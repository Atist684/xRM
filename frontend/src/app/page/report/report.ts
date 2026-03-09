import { Component, inject, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatTableModule } from '@angular/material/table';
import { PartnerService } from '../../service/partner';
import { PageTemplate } from '../template/page-template';

@Component({
  selector: 'app-report',
  imports: [MatTableModule, MatFormFieldModule, MatSelectModule, MatInputModule, FormsModule],
  templateUrl: './report.html',
  styleUrl: './report.css',
})
export class Report extends PageTemplate implements OnInit{

  readonly partnerService = inject(PartnerService);
  displayedColumns: string[] = ['name', 'time', 'partners'];

  ngOnInit(): void {
    this.partnerService.loadReport();
  }

}
