package com.chriswininger.musetest.controllers.Repositories.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Repository
{
  private int id;
  private String name;
  private String fullName;
  private boolean isPrivate;
  private String htmlUrl;
  private String description;
}
