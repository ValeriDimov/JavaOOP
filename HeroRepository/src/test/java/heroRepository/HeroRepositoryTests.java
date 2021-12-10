package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HeroRepositoryTests {
    private HeroRepository heroRepository;
    private Hero hero;

    @Before
    public void setUp() {
        heroRepository = new HeroRepository();
    }

    @Test(expected = NullPointerException.class)
    public void testCreateWithExceptionWhenHeroIsNull() {
        heroRepository.create(hero);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateWithExceptionWhenHeroAlreadyAdded() {
        hero = new Hero("Pesho", 10);
        Hero hero2 = new Hero("Valeri", 100);
        Hero hero3 = new Hero("Valeri", 150);

        heroRepository.create(hero);
        heroRepository.create(hero2);
        heroRepository.create(hero3);
    }

    @Test
    public void testCreateSuccessfullyHero() {
        hero = new Hero("Pesho", 10);
        Hero hero2 = new Hero("Valeri", 100);

        heroRepository.create(hero);
        String s2 = heroRepository.create(hero2);
        String s1 = "Successfully added hero Valeri with level 100";

        Assert.assertEquals(2, heroRepository.getCount());
        Assert.assertEquals("Valeri", heroRepository.getHero("Valeri").getName());
        Assert.assertEquals(s1, s2);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveWithExceptionWhenHeroIsNull() {
        heroRepository.remove("");
    }

    @Test
    public void testRemoveSuccessfullyHero() {
        hero = new Hero("Pesho", 10);
        Hero hero2 = new Hero("Valeri", 100);

        heroRepository.create(hero);
        heroRepository.create(hero2);

        boolean removedHero = heroRepository.remove("Valeri");

        Assert.assertTrue(removedHero);
        Assert.assertEquals(1, heroRepository.getCount());
    }

    @Test
    public void testGetHeroWithHighestLevel() {
        hero = new Hero("Pesho", 10);
        Hero hero2 = new Hero("Valeri", 100);

        heroRepository.create(hero);
        heroRepository.create(hero2);

        Hero heroWithHighestLevel = heroRepository.getHeroWithHighestLevel();
        Assert.assertEquals(hero2, heroWithHighestLevel);
    }

    @Test
    public void testGetHeroMethod() {
        hero = new Hero("Pesho", 10);
        Hero hero2 = new Hero("Valeri", 100);

        heroRepository.create(hero);
        heroRepository.create(hero2);

        Hero repositoryHero = heroRepository.getHero("Valeri");
        Assert.assertEquals(hero2, repositoryHero);
    }

    @Test
    public void testGetHeroesCollectionMethod() {
        hero = new Hero("Pesho", 10);
        Hero hero2 = new Hero("Valeri", 100);

        heroRepository.create(hero);
        heroRepository.create(hero2);

        List<Hero> heroList = new ArrayList<>();
        heroList.add(hero);
        heroList.add(hero2);

        Collection<Hero> myHeroes = Collections.unmodifiableCollection(heroList);

        Collection<Hero> heroes = heroRepository.getHeroes();
        Assert.assertEquals(heroList.size(), heroes.size());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetHeroesCollectionExceptionWhenClear() {
        hero = new Hero("Pesho", 10);
        Hero hero2 = new Hero("Valeri", 100);

        heroRepository.create(hero);
        heroRepository.create(hero2);

        Collection<Hero> heroes = heroRepository.getHeroes();
        heroes.clear();

    }

}
