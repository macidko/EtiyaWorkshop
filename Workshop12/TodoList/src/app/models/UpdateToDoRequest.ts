export interface UpdateTodoRequest {
  userId: number;
  id: number;
  title: string;
  completed: boolean;
}
