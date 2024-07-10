document.addEventListener("DOMContentLoaded", () => {
    const carousel = document.querySelector(".carousel");
    M.Carousel.init(carousel, {
        duration: 0,
        dist:-100,
        shift:50,
        padding:0,
        numVisible:3,
        indicators:true,
        noWrap:false,
    });
});