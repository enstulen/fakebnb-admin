jQuery(document).ready(function ($) {
    $(".clickable-row").click(function (event) {
        if (event.target.nodeName !== "DIV") {
            window.location = $(this).data("href");
        }
    });
});
