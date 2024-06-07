import { Component } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent {

  stId: any;
  StudentName: any;
  constructor(private router: ActivatedRoute, private route: Router) {
    // this.StudentId = this.router.snapshot.paramMap.get('id');
    // this.StudentName = this.router.snapshot.paramMap.get('name');
    this.router.paramMap.subscribe((data:ParamMap)=>
    {
      this.stId=data.get('id')
    })
  }

  nextid() {
    let next = parseInt(this.stId) + 1
    this.route.navigate(['/details', next])
  }
  previd() {
    let prev = parseInt(this.stId) - 1
    this.route.navigate(['/details', prev])

  }
}
