import express from "express";


const server = express();

server.use(express.static("dist"));

server.set("view engine","ejs")

server.use("/", (req, res) => {
    res.render("index",{
        initialContent: "Loading...",
    })
});

server.listen(8080, () =>
    console.info(
        "Express server is listening to http://localhost:8080/",
));