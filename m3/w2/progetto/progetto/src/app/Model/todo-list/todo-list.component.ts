import { Component, Input, OnInit } from '@angular/core';
import { Todo } from '../todo';
import { TodosService } from '../todos.service';

@Component({
  selector: '.app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.scss']
})
export class TodoListComponent implements OnInit {

  @Input() todos!: Todo[];

  constructor(private todoSvc: TodosService) { }

  ngOnInit(): void {
  }

  isCompleted(todo: Todo): void {

    this.todoSvc.setCompleted(todo)

    todo.id && (this.todos = this.todoSvc.removeTodoFromArr(this.todos, todo.id))

  }

  deleteTodo(todo: Todo): void {

    this.todoSvc.deleteTodo(todo)

    todo.id && (this.todos = this.todoSvc.removeTodoFromArr(this.todos, todo.id))

  }

}
