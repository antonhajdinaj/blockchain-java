package com.anton.blockchain;

import com.anton.blockchain.domain.Block;
import com.anton.blockchain.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlockController {

    @Autowired
    private BlockService blockService;

    @RequestMapping("")
    public String index() {
        return "Greetings from Anton!";
    }

    @RequestMapping(path = "/blockchain/add/{data}")
    public ResponseEntity addData(@PathVariable("data") String data) {
        Block lastBlock = blockService.getLastBlock();
        Block newBlock = new Block(lastBlock.getHash(), data);
        blockService.addBlock(newBlock);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(path = "/blockchain/blocks", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Block> getAllBlocks() {
        return blockService.getAllBlocks();
    }


}
