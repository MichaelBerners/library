package security;

import com.example.library.domain.entity.Person;
import com.example.library.domain.entity.PersonRole;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

//класс обертка над Person
@AllArgsConstructor
public class PersonDetails implements UserDetails {

    private final Person person;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null; //List.of(new SimpleGrantedAuthority(person.getRole().name())); //возвращает список прав
    }

    @Override
    public String getPassword() {
        return person.getPassword();
    }

    @Override
    public String getUsername() {
        return person.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; //аккаунт не просрочен
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; //аккауни не заблокирован
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; //пароль не просрочен
    }

    @Override
    public boolean isEnabled() {
        return true; //рабочий аккаунт
    }

    public Person getPerson() {
        return person;
    }
}
