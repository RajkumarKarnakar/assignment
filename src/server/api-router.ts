import express from "express";
import testData from "../data/sample-data.json"

const router = express.Router();

router.get("/sample", (req,res) => {
    res.send(testData)
});

export default router;