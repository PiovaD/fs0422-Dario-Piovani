import { Component, OnInit } from '@angular/core';
import { Todo } from 'src/app/Model/todo';
import { TodosService } from 'src/app/Model/todos.service';

@Component({
  selector: 'app-completed',
  templateUrl: './completed.component.html',
  styleUrls: ['./completed.component.scss']
})
export class CompletedComponent implements OnInit {

  arrEmptyTxt: string = "Ops, non ci sono Task";
  fetchingTxt: string = "Recupero Task..."

  isFetching: boolean = true;

  todos: Todo[] = [];

  constructor(private todoSvc: TodosService) { }

  ngOnInit(): void {

    this.todoSvc.getAllTodos()
      .then(todos => {
        this.todos = this.todoSvc.filterTodos(todos, true)
        this.isFetching = false;
      })

  }

}
