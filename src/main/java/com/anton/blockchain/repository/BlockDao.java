package com.anton.blockchain.repository;

import com.anton.blockchain.domain.Block;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class BlockDao {

    private List<Block> blocks = new ArrayList<>();

    public void addBlock(Block block) {
        blocks.add(block);
    }

    public Block getLastBlock() {
        return blocks.isEmpty() ? null : blocks.get(blocks.size() - 1);
    }

    public List<Block> getAllBlocks() {
        return Collections.unmodifiableList(blocks);
    }
}
