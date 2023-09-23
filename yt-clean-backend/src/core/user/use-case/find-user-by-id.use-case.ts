import { UserModel } from '../model/user.model';
import { UseCase } from '../../shared/use-case';
import { UserRepository } from '../repository/user.repository';

export class FindUserByIdUseCase implements UseCase<string, UserModel | null> {
  constructor(private readonly userRepository: UserRepository) {}

  public async execute(id: string): Promise<UserModel | null> {
    return this.userRepository.findById(id);
  }
}
