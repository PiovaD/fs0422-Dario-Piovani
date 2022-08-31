import {User} from './User'
import {Address} from './Address'

class Invoice{

    id:number| undefined;
    readonly date!:Date;
    expiration!:Date;
    userId!: number;
    user:User | undefined;
    billingAddress!: Address;
    rows: any[] = [];

    constructor(billingAddress: Address){
        this.billingAddress = billingAddress || this.user?.billingAddress
        
    }
}