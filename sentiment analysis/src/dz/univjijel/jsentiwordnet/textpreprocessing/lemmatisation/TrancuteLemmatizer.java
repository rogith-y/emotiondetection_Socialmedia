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
package dz.univjijel.jsentiwordnet.textpreprocessing.lemmatisation;

/**
 *
 * @author Tarek Boutefara <t_boutefara@esi.dz>
 */
public class TrancuteLemmatizer implements Lemmatizer {
    
    int size;

    public TrancuteLemmatizer(int size) {
        this.size = size;
    }

    @Override
    public String lemme(String term) {
        if(term.length() < size)
            return term;
        return term.substring(0, size);
    }
    
}
