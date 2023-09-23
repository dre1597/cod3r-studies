import { Elysia } from 'elysia';

import { CreateUserUseCase } from '../../core/user/use-case/create-user.use-case';

export class CreateUserController {
  constructor(
    private readonly server: Elysia,
    private readonly createUserUseCase: CreateUserUseCase
  ) {
    server.post('/users', async (ctx) => {
      const { name, email, password } = ctx.body as any;
      await this.createUserUseCase.execute({ name, email, password });

      return {
        message: 'User created'
      };
    });
  }


}
