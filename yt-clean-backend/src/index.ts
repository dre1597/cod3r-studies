import { Elysia } from 'elysia';
import { InMemoryUserRepository } from './external/in-memory/in-memory-user.repository';
import { CreateUserUseCase } from './core/user/use-case/create-user.use-case';
import { CreateUserController } from './adapters/user/create-user.controller';

const app = new Elysia();

const userRepository = new InMemoryUserRepository();
const createUserUseCase = new CreateUserUseCase(userRepository);
new CreateUserController(app, createUserUseCase);

const port = 3000

app.listen(port);


console.log(
  `🦊 Elysia is running at ${app.server?.hostname}:${app.server?.port}`
);
