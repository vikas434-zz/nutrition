package co.rivatech.nutrition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import co.rivatech.nutrition.model.Block;
import co.rivatech.nutrition.repository.BlockRepository;

/**
 * @author vranjan
 * created 07/08/2021
 */
@Service
public class BlockService {

    @Autowired
    private BlockRepository blockRepository;


    public List<Block> getAllBlocks() {
        List<Block> blocks = new ArrayList<>();
        Iterable<Block> items = blockRepository.findAll();
        items.forEach(blocks::add);
        return blocks;
    }

    public Block addBlock(final Block block) {
        blockRepository.save(block);
        return block;
    }

    public Optional<Block> getBlockById(final int blockId) {
        return blockRepository.findById(blockId);
    }
}
