import { UseCase } from '../../shared/use-case';
import { UserModel } from '../model/user.model';
import { UserRepository } from '../repository/user.repository';

export class ListUsersUseCase implements UseCase<void, UserModel[]> {
  constructor(private readonly userRepository: UserRepository) {}

  public async execute(): Promise<UserModel[]> {
    return this.userRepository.findAll();
  }
}
