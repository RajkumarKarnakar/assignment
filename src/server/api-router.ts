import express from "express";
import cors from "cors";

import { connectClient } from "./db";

const router = express.Router();
router.use(cors());

router.get("/api/sample", async (req, res) => {
  const client = await connectClient();
  const sampleData = await client
    .collection("sample")
    .find()
    .project({
      ts: 1,
      machine_status: 1,
      vibration: 1,
    })
    .toArray();

  res.send({ sampleData });
});