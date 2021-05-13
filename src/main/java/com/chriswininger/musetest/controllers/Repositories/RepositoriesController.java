package com.chriswininger.musetest.controllers.Repositories;

import java.util.List;

import com.chriswininger.musetest.controllers.Repositories.dtos.Repository;
import com.github.javafaker.Faker;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RepositoriesController
{
  public static final String END_POINT_V1 = "/api/v1/repositories";

  private static final Faker faker = new Faker();

  @GetMapping(END_POINT_V1)
  @ResponseBody
  public List<Repository> getRepositories() {
    return generateRandomRepositories();
  }

  @GetMapping(END_POINT_V1 + "/name/{id}")
  @ResponseBody
  public String getNameById(@PathVariable final int id) {
    List<Repository> repositories = generateRandomRepositories();

    return repositories.get(id).getName();
  }

  private List<Repository> generateRandomRepositories() {
    final int numRepos = faker.random().nextInt(1, 10);

    final List<Repository> repositories = Lists.newArrayList();
    for (int i = 0; i < numRepos; i++) {
      repositories.add(generateRandomRepository());
    }

    return repositories;
  }

  private Repository generateRandomRepository() {
    return Repository.builder()
        .id(faker.random().nextInt(Integer.MAX_VALUE))
        .name(faker.beer().style())
        .fullName(faker.beer().name())
        .isPrivate(faker.random().nextBoolean())
        .htmlUrl(faker.internet().url())
        .description(faker.lebowski().quote())
        .build();
  }
}
