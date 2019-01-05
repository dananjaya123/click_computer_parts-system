package lk.ijse.gdse.computerParts.business.custom.impl;

import lk.ijse.gdse.computerParts.business.custom.ItemBusiness;
import lk.ijse.gdse.computerParts.dto.ItemDTO;
import lk.ijse.gdse.computerParts.entity.Item;
import lk.ijse.gdse.computerParts.repository.RepoFactory;
import lk.ijse.gdse.computerParts.repository.custom.ItemRepo;
import lk.ijse.gdse.computerParts.resources.HibernetUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class ItemBusinessImpl implements ItemBusiness {

    ItemRepo itemRepo= RepoFactory.getInstance().getRepositoryFor(RepoFactory.RepoTypes.ITEM);

    public ItemBusinessImpl() {
    }

    @Override
    public boolean addItem(ItemDTO itemDTO) throws Exception {
       try(Session session=HibernetUtil.getSessionFactory().openSession()){
           itemRepo.setSession(session);
           session.getTransaction().begin();
           session.save(new Item(itemDTO.getIid(),itemDTO.getItemName(),itemDTO.getItemBrand(),itemDTO.getDiscription(),itemDTO.getQty(),itemDTO.getUnitPrice()));
           session.getTransaction().commit();
       }
       return true;
    }

    @Override
    public boolean deleteItem(ItemDTO itemDTO) throws Exception {
       try (Session session=HibernetUtil.getSessionFactory().openSession()){
           itemRepo.setSession(session);
           session.getTransaction().begin();
           session.delete(new Item(itemDTO.getIid(),itemDTO.getItemName(),itemDTO.getItemBrand(),itemDTO.getDiscription(),itemDTO.getQty(),itemDTO.getUnitPrice()));
           session.getTransaction().commit();
       }
       return true;
    }

    @Override
    public boolean updateItem(ItemDTO itemDTO) throws Exception {
        try (Session session=HibernetUtil.getSessionFactory().openSession()){
            itemRepo.setSession(session);
            session.getTransaction().begin();
            session.update(new Item(itemDTO.getIid(),itemDTO.getItemName(),itemDTO.getItemBrand(),itemDTO.getDiscription(),itemDTO.getQty(),itemDTO.getUnitPrice()));
            session.getTransaction().commit();
        }
        return true;
    }

    @Override
    public ItemDTO searchItem(String id) throws Exception {
        try (Session session=HibernetUtil.getSessionFactory().openSession()){
            itemRepo.setSession(session);
            session.getTransaction().begin();
            Item search = itemRepo.search(id);
            session.getTransaction().commit();
            return new ItemDTO(search.getIid(),search.getItemName(),search.getItemBrand(),search.getDiscription(),search.getQty(),search.getUnitPrice());
        }
    }

    @Override
    public ArrayList<ItemDTO> getAllItem() throws Exception {
       ArrayList<ItemDTO>itemDTOS=new ArrayList<>();
       try (Session session=HibernetUtil.getSessionFactory().openSession()){
           itemRepo.setSession(session);
           session.getTransaction().begin();
           List<Item>items=itemRepo.getAll();
           for (Item item:items){
               itemDTOS.add(new ItemDTO(item.getIid(),item.getItemName(),item.getItemBrand(),item.getDiscription(),item.getQty(),item.getUnitPrice()));
           }
           session.getTransaction().commit();
       }
        return itemDTOS;
    }
}
