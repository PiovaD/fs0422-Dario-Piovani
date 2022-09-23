import { IUser } from "./iuser";

export interface IPost {
  id: number
  userId: number;
  parentId?: number

  date: Date;
  title: string;
  content: string;

  allLikeId:number[];
  allDislikeId:number[];

  userObj?: IUser;
  replayForm?: boolean;
}
