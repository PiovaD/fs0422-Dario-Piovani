export class Post {
    id!:number;
    body:string;
    title:string;
    active:boolean;
    type:string;
    author:string;

    constructor(body:string, title:string, type:string, active:boolean, author:string) {
        this.body=body
        this.title=title
        this.type=type
        this.active=active
        this.author=author
    }
}
