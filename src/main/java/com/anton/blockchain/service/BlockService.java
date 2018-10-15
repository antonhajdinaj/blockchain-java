package com.anton.blockchain.service;

import com.anton.blockchain.domain.Block;
import com.anton.blockchain.repository.BlockDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockService {

    @Autowired
    private BlockDao blockDao;

    public Block getLastBlock() {
        Block lastBlock = blockDao.getLastBlock();
        if (lastBlock == null) {
            return new Block("0", "First block");
        }
        return lastBlock;
    }

    public void addBlock(Block block) {
        blockDao.addBlock(block);
    }

    public List<Block> getAllBlocks() {
        return blockDao.getAllBlocks();
    }
}
