import { Elysia } from 'elysia';

import { ListUsersUseCase } from '../../core/user/use-case/list-users.use-case';

export class ListUsersController {
  constructor(
    private readonly server: Elysia,
    private readonly listUsersUseCase: ListUsersUseCase,
  ) {
    server.get('/users', async () => {
      return await this.listUsersUseCase.execute();
    });
  }
}
