import { Component, OnInit } from '@angular/core';
import { Todo } from 'src/app/Model/todo';
import { TodosService } from 'src/app/Model/todos.service';

@Component({
  selector: 'app-todos',
  templateUrl: './todos.component.html',
  styleUrls: ['./todos.component.scss']
})
export class TodosComponent implements OnInit {

  arrEmptyTxt: string = "Non hai Task";
  fetchingTxt: string = "Recupero Task..."

  isFetching: boolean = true;

  todos: Todo[] = [];

  newTodo: Todo = {
    id: undefined,
    title: '',
    completed: false
  };

  constructor(private todoSvc: TodosService) { }

  ngOnInit(): void {

    this.todoSvc.getAllTodos()
      .then(todos => {
        this.todos = this.todoSvc.filterTodos(todos, false)
        this.isFetching = false;
      })

  }

  saveTodo() {
    this.todoSvc.addTodo(this.newTodo)
      .then(res => this.todos.push(res));
    this.newTodo.title = ''
  }

}
