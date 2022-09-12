export class Post {
  id: number| undefined;
  title: string;
  content: string
  date:Date;

  constructor(title: string, content: string, date: Date = new Date()) {
    this.title = title;
    this.content = content;
    this.date = date;
  }
}
