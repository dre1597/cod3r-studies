import { UserModel } from '../model/user.model';

export interface UserRepository {
  findByEmail(email: string): Promise<UserModel | null>;
  save(user: UserModel): Promise<UserModel>;
}
