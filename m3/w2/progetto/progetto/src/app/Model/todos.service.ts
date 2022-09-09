import { Injectable } from '@angular/core';
import { Todo } from './todo';

@Injectable({
  providedIn: 'root'
})
export class TodosService {

  private API_TODOS: string = "http://localhost:3000/todos"

  constructor() { }

  getAllTodos(): Promise<Todo[]> {
    return new Promise<Todo[]>((resolve) => {
      setTimeout(() => {
        let call = fetch(this.API_TODOS)
          .then(res => res.json())
        resolve(call)
      }, 2000)
    })
  }

  filterTodos(todos: Todo[], completed: boolean): Todo[] {
    return todos.filter((t: Todo) => t.completed === completed)
  }

  getTodoById(arrTodo: Todo[], id: number): Todo | null {

    return arrTodo.find((t: Todo) => t.id === id) || null
  }

  removeTodoFromArr(arrTodo: Todo[], id: number): Todo[] {
    let index = arrTodo.findIndex(t => t.id === id)
    arrTodo.splice(index, 1)

    return arrTodo
  }

  setCompleted(todo: Todo): void {
    todo.completed = !todo.completed

    let options = {
      method: 'PUT',
      body: JSON.stringify(todo),
      headers: { "content-type": "application/json" }
    }

    fetch(this.API_TODOS + '/' + todo.id, options)
  }

  addTodo(todo: Todo): Promise<Todo> {

    let options = {
      method: 'POST',
      body: JSON.stringify(todo),
      headers: { "content-type": "application/json" }
    }

    return fetch(this.API_TODOS, options)
      .then(res => res.json())

  }

  deleteTodo(todo: Todo): void {

    let options = {
      method: 'DELETE',
      headers: { "content-type": "application/json" }
    }

    fetch(this.API_TODOS + '/' + todo.id, options)
  }

}
