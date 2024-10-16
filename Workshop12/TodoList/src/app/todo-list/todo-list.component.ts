import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { TodoCardComponent } from '../todo-card/todo-card.component';
import { HttpClient } from '@angular/common/http';
import { GetToDoListResponse } from '../models/getToDoListResponse';
import { CreateToDoRequest } from '../models/CreateToDoRequest';
import { CreateToDoResponse } from '../models/CreateToDoResponse';
import { UpdateTodoRequest } from '../models/UpdateToDoRequest';
import { UpdateTodoResponse } from '../models/UpdateTodoResponse';

@Component({
  selector: 'app-todo-list',
  standalone: true,
  imports: [FormsModule, CommonModule, TodoCardComponent],
  templateUrl: './todo-list.component.html',
  styleUrl: './todo-list.component.scss',
})
export class TodoListComponent implements OnInit {
  name: string = '';
  todos: string[] = [];
  todoListFromBackend: GetToDoListResponse[] = [];

  //appconfig->providehttpclient(), ctor(httpclient), fetchmethods, models, oninitfnc, implement oninit

  /**
   *
   */
  constructor(private httpClient: HttpClient) {}

  ngOnInit() {
    this.fetchTodos();
  }

  saveToDo() {
    let isContain = this.isContain();

    if (!isContain) {
      this.todos.push(this.name);
    } else {
      alert('bu todo mevcut: ' + `"${this.name}"`);
    }
    this.name = '';
  }

  isContain() {
    return this.todos.some((todo) => todo === this.name);
  }

  deleteTodo(todo: string) {
    this.todos = this.todos.filter((arrTodo) => arrTodo != todo);
  }

  fetchTodos() {
    this.httpClient
      .get<GetToDoListResponse[]>('https://jsonplaceholder.typicode.com/todos')
      .subscribe({
        next: (response: GetToDoListResponse[]) => {
          this.todoListFromBackend = response;
          console.log(this.todoListFromBackend);
        },
        error: (err: any) => {
          console.log('hata: ', err);
        },
        complete: () => {
          console.log('istek başarılı bitti');
        },
      });
    //add
    //update
    //delete
  }
  addTodo() {
    const newTodo: CreateToDoRequest = {
      userId: 1,
      title: 'New Todo',
      completed: false,
    };
    this.httpClient
      .post<CreateToDoResponse>(
        'https://jsonplaceholder.typicode.com/todos',
        newTodo
      )
      .subscribe({
        next: (response: CreateToDoResponse) => {
          console.log('Add Response: ', response);
          this.todoListFromBackend.push(response);
        },
        error: (err: any) => {
          alert(`hata: ${err}`);
        },
        complete: () => {
          console.log('POST işlemi sonlandı.');
        },
      });
  }

  updateTodo(todo: UpdateTodoRequest) {
    const updateTodo: UpdateTodoRequest = {
      ...todo,
      title: 'Updated Title',
    };

    this.httpClient
      .put<UpdateTodoResponse>(
        `https://jsonplaceholder.typicode.com/todos/${updateTodo.id}`,
        updateTodo
      )
      .subscribe({
        next: (response: UpdateTodoResponse) => {
          console.log('Add Response: ', response);
          // this.todoListFromBackend.push(response);
          const index = this.todoListFromBackend.findIndex(
            (t) => t.id === todo.id
          );
          if (index !== -1) {
            this.todoListFromBackend[index] = response;
          }
        },
        error: (err: any) => {
          alert(`hata: ${err}`);
        },
        complete: () => {
          console.log('POST işlemi sonlandı.');
        },
      });
  }

  deleteTodoWithId(todoId: number) {
    this.httpClient
      .delete(`https://jsonplaceholder.typicode.com/todos/${todoId}`)
      .subscribe({
        next: () => {
          console.log(`Todo silme başarılı.`);
          this.todoListFromBackend = this.todoListFromBackend.filter(
            (t) => t.id !== todoId
          );
        },
        error: (err) => {
          console.error(`Error deleting todo: ${err}`);
        },
        complete: () => {
          console.log('DELETE işlemi sonlandı.');
        },
      });
  }

  getById() {
    this.httpClient
      .get<GetToDoListResponse[]>(
        `https://jsonplaceholder.typicode.com/todos/${this.name}`
      )
      .subscribe({
        next: (response: GetToDoListResponse[]) => {
          alert(JSON.stringify(response, null, 2));
          // console.log(response);
        },
        error: (err: any) => {
          console.log('hata: ', err);
        },
        complete: () => {
          console.log('istek başarılı bitti');
        },
      });
  }
}
// Backend isteklerinin her birini çalıştıran kodları yazalım
// Ekleme işlemi post isteği
// Detay sayfası oluşturup orada da örnek bir id (1) detay isteği atsın
// Silme işlemi delete isteği atsın
