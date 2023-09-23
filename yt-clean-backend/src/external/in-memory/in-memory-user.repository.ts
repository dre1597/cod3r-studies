import { UserRepository } from '../../core/user/repository/user.repository';
import { UserModel } from '../../core/user/model/user.model';

export class InMemoryUserRepository implements UserRepository {

  private readonly users: UserModel[] = [];

  public async findByEmail(email: string): Promise<UserModel | null> {
    return this.users.find(user => user.email === email) ?? null;
  }

  public async save(user: UserModel): Promise<UserModel> {
    const newUser = { ...user, id: crypto.randomUUID() };
    this.users.push(newUser);
    return newUser;
  }

  public async findAll(): Promise<UserModel[]> {
    return this.users.slice();
  }
}
