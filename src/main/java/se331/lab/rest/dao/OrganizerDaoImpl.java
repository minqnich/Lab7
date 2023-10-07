package se331.lab.rest.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Organizer;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrganizerDaoImpl implements OrganizerDao{
    List<Organizer> organizerList;

    @PostConstruct
    public  void init() {
        organizerList = new ArrayList<>();
        organizerList.add(Organizer.builder()
                .id(5928101L)
                .category("animal welfare")
                .title("Cat Adoption Day")
                .description("Find your new feline friend at this event.")
                .location("Meow Town")
                .date("January 28, 2022")
                .time("12:00")
                .petAllowed(true)
                .organizer("Kat Laydee")
                .build());
        organizerList.add(Organizer.builder()
                .id(4582797L)
                .category("food")
                .title("Community Gardening")
                .description("Join us as we tend ti the community edible plants.")
                .location("Flora City")
                .date("March 14, 2022")
                .time("10:00")
                .petAllowed(true)
                .organizer("Fern Pollin")
                .build());
        organizerList.add(Organizer.builder()
                .id(8419988L)
                .category("sustainability")
                .title("Beach Cleanup")
                .description("Help pick up trash along the shore.")
                .location("Playa Del Carmen")
                .date("July 22, 2022")
                .time("11:00")
                .petAllowed(true)
                .organizer("Carey Wales")
                .build());

    }
    @Override
    public Integer getOrganizerSize() {
        return organizerList.size();
    }

    @Override
    public List<Organizer> getOrganizer(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? organizerList.size() : pageSize;
        page = page == null ? 1 : page;
        Integer firstIndex = (page - 1) * pageSize;
        List<Organizer> output = new ArrayList<>();
        for (int i = firstIndex; i < firstIndex + pageSize; i++) {
            output.add(organizerList.get(i));
        }
        return output;
    }

    @Override
    public Organizer getOrganizer(Long id) {
        Organizer output = null;
        for (Organizer organizer :
                organizerList) {
            if (organizer.getId().equals(id)) {
                output = organizer;
                break;
            }
        }
        return output;
    }
}
