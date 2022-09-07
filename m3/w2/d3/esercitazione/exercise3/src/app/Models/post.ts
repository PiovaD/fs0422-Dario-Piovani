export class Post {
    id!:number;
    body:string;
    title:string;
    active:boolean;
    type:string;

    constructor(body:string, title:string, type:string, active:boolean){
        this.body=body
        this.title=title
        this.type=type
        this.active=active
    }
}
