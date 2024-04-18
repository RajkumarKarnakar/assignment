import express from "express";
import config from "./config"
import apiRouter from "./api-router"

const server = express();

server.use(express.static("dist"));

server.set("view engine","ejs")

server.use("/api",apiRouter);

server.get("/", (req, res) => {
    res.render("index",{
        initialContent: "Loading...",
    })
});

server.listen(config.PORT, () =>
    console.info(
        `Express server is listening to http://localhost:${config.PORT}/`,
));