import { Elysia } from 'elysia';

import { CreateUserUseCase } from './core/user/use-case/create-user.use-case';
import { CreateUserController } from './adapters/user/create-user.controller';
import { PrismaUserRepository } from './external/prisma/prisma-user.repository';

const app = new Elysia();

// const userRepository = new InMemoryUserRepository();
const userRepository = new PrismaUserRepository();
const createUserUseCase = new CreateUserUseCase(userRepository);
new CreateUserController(app, createUserUseCase);

const port = 3000

app.listen(port);


console.log(
  `🦊 Elysia is running at ${app.server?.hostname}:${app.server?.port}`
);
