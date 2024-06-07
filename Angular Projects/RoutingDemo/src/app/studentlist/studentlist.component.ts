import { Component  , OnInit} from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-studentlist',
  templateUrl: './studentlist.component.html',
  styleUrls: ['./studentlist.component.css']
})
export class StudentlistComponent implements OnInit{

  constructor( private router:Router){}
  ngOnInit(): void {
    
  }

students=[
  {
    'id':1,
    'name':'Dhaval',
    'city':'ahmedabad',
    'number':8128401450
  },
  {
    'id':2,
    'name':'rinkal',
    'city':'ahmedabad',
    'number':8128401450
  },
  {
    'id':3,
    'name':'kunj',
    'city':'ahmedabad',
    'number':8128401450
  },
  {
    'id':4,
    'name':'rajat',
    'city':'ahmedabad',
    'number':8128401450
  },
  {
    'id':5,
    'name':'kashyap',
    'city':'ahmedabad',
    'number':8128401450
  },
];


getstudentObject(st: any) {
  this.router.navigate(['/details', st.id]);
}



}
