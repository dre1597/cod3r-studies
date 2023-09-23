import { Elysia } from 'elysia';

import { PrismaUserRepository } from './external/prisma/prisma-user.repository';
import { CreateUserUseCase } from './core/user/use-case/create-user.use-case';
import { ListUsersUseCase } from './core/user/use-case/list-users.use-case';
import { FindUserByIdUseCase } from './core/user/use-case/find-user-by-id.use-case';
import { CreateUserController } from './adapters/user/create-user.controller';
import { ListUsersController } from './adapters/user/list-users.controller';
import { FindUserByIdController } from './adapters/user/find-user-by-id.controller';

const app = new Elysia();

// const userRepository = new InMemoryUserRepository();
const userRepository = new PrismaUserRepository();

const createUserUseCase = new CreateUserUseCase(userRepository);
new CreateUserController(app, createUserUseCase);

const listUsersUseCase = new ListUsersUseCase(userRepository);
new ListUsersController(app, listUsersUseCase);

const findUserByIdUseCase = new FindUserByIdUseCase(userRepository);
new FindUserByIdController(app, findUserByIdUseCase);

const port = 3000;

app.listen(port);


console.log(
  `🦊 Elysia is running at ${app.server?.hostname}:${app.server?.port}`
);
