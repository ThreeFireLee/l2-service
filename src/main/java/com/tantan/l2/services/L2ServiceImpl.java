package com.tantan.l2.services;

import com.tantan.l2.clients.MergerClient;
import com.tantan.l2.models.Resp;

public class L2ServiceImpl implements L2Service{

  /**
   * This method will get a user from id
   * @param id - user id
   * @return
   */
  @Override
  public Resp getUsers(Long id, String limit, String search, String filter, String with) {
    MergerClient mergerClient = new MergerClient();
    return mergerClient.getUsers(id, limit, search, filter, with);
  }
}
