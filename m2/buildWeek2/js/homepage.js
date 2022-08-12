const innerCarousel = document.querySelector('#inner-carousel')
const indicatorCarousel = document.querySelector('#indicators')

const latestPost = document.querySelector("#latest-post")

class homePagePost {
    constructor(target) {
        fetch(homePostAPI)
            .then(res => res.json())
            .then(res => {
                for (let i = 1; i <= 10 && i <= res.length; i++) {

                    let user = res[res.length - i]

                    target.append(this.createArticle(user))

                }

            })
    }

    createArticle(post) {
        let article = document.createElement('article')
        article.className = "bg-primary bg-opacity-25 container border-bottom border-primary rounded p-4 mb-3"
        let title = document.createElement('h5')
        title.className ="text-primary"
        title.innerText = post.username

        let description = document.createElement('p')
        description.innerText = post.post

        article.append(title, description)

        return article
    }
}

class homeCarousel {
    constructor(inner, indicator) {

        fetch(userAPI)
            .then(res => res.json())
            .then(res => {

                this.isFirst = true
                let slide = 0

                for (let i = 0; i < res.length && slide < 5; i++) {

                    if (res[res.length - 1 - i].company && res[res.length - 1 - i].company.name && res[res.length - 1 - i].company.bs && res[res.length - 1 - i].company.catchPhrase) {


                        indicator.append(this.createIndicator(slide))

                        inner.append(this.createInner(res[res.length - 1 - i]))

                        this.isFirst = false
                        slide++

                    }
                }
            })
    }

    createIndicator(num) {

        let btn = document.createElement('button');
        btn.type = 'button'
        btn.setAttribute('data-bs-target', "#carousel")
        btn.setAttribute('data-bs-slide-to', num)
        btn.setAttribute('aria-label', "Slide" + (parseInt(num) + 1))

        if (this.isFirst) {
            btn.classList.add('active');
            btn.setAttribute('aria-current', "true")
        }

        return btn
    }

    createInner(user) {
        let div = document.createElement('div')
        div.className = "carousel-item text-center px-5 py-5"
        div.setAttribute('data-bs-interval', "5000")

        this.isFirst && div.classList.add('active')

        this.contentCreate('h3', user.company.name, user.company.catchPhrase, div)
        this.contentCreate('h5', user.name.replaceAll('-', ' '), user.company.bs, div)

        return div

    }

    contentCreate(tag, title, description, div) {
        let h = document.createElement(tag)
        h.innerText = title

        let p = document.createElement('p')
        p.innerText = description

        div.append(h, p)
    }
}

let c = new homeCarousel(innerCarousel, indicatorCarousel)
let p = new homePagePost(latestPost);
