import { PrismaClient } from '@prisma/client';

import { UserRepository } from '../../core/user/repository/user.repository';
import { UserModel } from '../../core/user/model/user.model';

export class PrismaUserRepository implements UserRepository {

  private prismaClient: PrismaClient;

  constructor() {
    this.prismaClient = new PrismaClient();
  }

  async findByEmail(email: string): Promise<UserModel | null> {
    return this.prismaClient.user.findUnique({
      where: { email }
    });
  }

  async save(user: UserModel): Promise<UserModel> {
    return this.prismaClient.user.create({ data: user });
  }

  public findAll(): Promise<UserModel[]> {
    return this.prismaClient.user.findMany();
  }

  public findById(id: string): Promise<UserModel | null> {
    return this.prismaClient.user.findUnique({
      where: { id }
    })
  }
}
