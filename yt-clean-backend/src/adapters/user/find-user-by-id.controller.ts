import { Elysia } from 'elysia';

import { FindUserByIdUseCase } from '../../core/user/use-case/find-user-by-id.use-case';

export class FindUserByIdController {
  constructor(
    private readonly server: Elysia,
    private readonly findUserByIdUseCase: FindUserByIdUseCase
  ) {
    server.get('/users/:id', async (ctx) => {
      const id = ctx.params.id;
      return await this.findUserByIdUseCase.execute(id);
    });
  }
}
