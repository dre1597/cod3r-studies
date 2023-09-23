import { UseCase } from '../../shared/use-case';
import { UserRepository } from '../repository/user.repository';

type Input = {
  name: string;
  email: string;
  password: string;
}

export class CreateUserUseCase implements UseCase<Input, void> {
  constructor(private readonly userRepository: UserRepository) {}

  public async execute(input: Input): Promise<void> {
    const { name, email, password } = input;

    const userExists = await this.userRepository.findByEmail(email);

    if (userExists) {
      throw new Error('User already exists');
    }

    await this.userRepository.save({ name, email, password });
  }
}
