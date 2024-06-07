import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { HtmltopdfService } from 'src/app/services/htmltopdf.service';

@Component({
  selector: 'app-htmltopdf',
  templateUrl: './htmltopdf.component.html',
  styleUrls: ['./htmltopdf.component.css']
})
export class HtmltopdfComponent {

  pdfForm:any;
  constructor(private fb:FormBuilder,private service:HtmltopdfService)
  {
    this.pdfForm=this.fb.group({
      file:[]
    })

  }
  onFileSelected(event: any) {
    if (event.target.files.length > 0) {
      const file = event.target.files[0];
      console.log("Selected filef+",file);
      this.pdfForm.get('file')?.setValue(file);
    }
  }

  onsubmit(){
    alert("clickes");
    // const file = this.pdfForm.get('file').value;
    // alert(file);
    const fileInput:File = this.pdfForm.get('file')?.value;
    alert("+++++++++" + fileInput)
    // if (fileInput && fileInput.value) {
      
      
      this.service.getPdf(fileInput).subscribe({
          next: (resp) => {
            const blob = new Blob([resp], { type: 'application/pdf' });
            const url = window.URL.createObjectURL(blob);
            const link = document.createElement('a');
            link.href = url;
            link.download = 'generated_pdf.pdf';
            link.click();
            window.URL.revokeObjectURL(url);},
          error: (err) => {
              console.log(err);
          }
      });
  // }
  }
}
