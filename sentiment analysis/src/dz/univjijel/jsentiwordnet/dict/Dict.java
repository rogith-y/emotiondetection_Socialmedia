/* 
 * Copyright (C) 2018 Tarek Boutefara <t_boutefara@esi.dz>.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package dz.univjijel.jsentiwordnet.dict;

import dz.univjijel.jsentiwordnet.core.Configuration;
import dz.univjijel.jsentiwordnet.dict.util.IncorrectSentiWordNetFile;
import dz.univjijel.jsentiwordnet.dict.util.IncorrectSynsetString;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tarek Boutefara <t_boutefara@esi.dz>
 */
public class Dict {
    
    final private List<Synset> synsets;

    public Dict() {
        synsets = new ArrayList<>();
    }

    public List<Synset> getSynsets() {
        return synsets;
    }
    
    public static Dict dictFactory(Configuration config) throws IncorrectSentiWordNetFile {
        try {
            Dict dict = new Dict();
            List<String> lines = Files.readAllLines(Paths.get(config.getDictPath()));
            for(String line : lines){
                if(line.startsWith("#") || line.equals("#"))
                        continue;
                dict.getSynsets().add(Synset.synsetFactory(line));
            }
            return dict;
        } catch (IOException | IncorrectSynsetString ex) {
            System.out.println(ex.getMessage());
            throw new IncorrectSentiWordNetFile(config.getDictPath());
        } 
    }
    
}
