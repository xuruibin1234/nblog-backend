package cn.xrb.clouduser.service.impl;

import cn.xrb.clouduser.entity.TUser;
import cn.xrb.clouduser.entity.TUserRole;
import cn.xrb.clouduser.mapper.T_userMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;

class T_userServiceImplTest {
    @Mock
    T_userMapper tUserMapper;

    @InjectMocks
    T_userServiceImpl t_userServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegister() {
        when(tUserMapper.findLastUserId()).thenReturn(null);
        when(tUserMapper.findUserByUsername(any(TUser.class))).thenReturn(1);
        when(tUserMapper.findUserByEmail(any(TUser.class))).thenReturn(Integer.valueOf(0));
        when(tUserMapper.findUserByPhone(any(TUser.class))).thenReturn(Integer.valueOf(0));

        String result = t_userServiceImpl.register(new TUser());
        verify(tUserMapper).register(any(TUser.class));
        Assertions.assertEquals("用户注册成功", result);
    }

    @Test
    void testGetBaseMapper() {
        T_userMapper result = t_userServiceImpl.getBaseMapper();
        Assertions.assertEquals(null, result);
    }

    @Test
    void testSave() {
        boolean result = t_userServiceImpl.save(new TUser());
        Assertions.assertEquals(true, result);
    }

    @Test
    void testSaveBatch() {
        boolean result = t_userServiceImpl.saveBatch(List.of(new TUser()), 0);
        Assertions.assertEquals(true, result);
    }

    @Test
    void testSaveOrUpdate() {
        boolean result = t_userServiceImpl.saveOrUpdate(new TUser());
        Assertions.assertEquals(true, result);
    }

    @Test
    void testSaveOrUpdateBatch() {
        boolean result = t_userServiceImpl.saveOrUpdateBatch(List.of(new TUser()), 0);
        Assertions.assertEquals(true, result);
    }

    @Test
    void testRemoveById() {
        boolean result = t_userServiceImpl.removeById(new TUserRole());
        Assertions.assertEquals(true, result);
    }

    @Test
    void testRemoveByMap() {
        boolean result = t_userServiceImpl.removeByMap(Map.of("columnMap", "columnMap"));
        Assertions.assertEquals(true, result);
    }

    @Test
    void testRemove() {
        boolean result = t_userServiceImpl.remove(null);
        Assertions.assertEquals(true, result);
    }

    @Test
    void testRemoveByIds() {
        boolean result = t_userServiceImpl.removeByIds(List.of(null));
        Assertions.assertEquals(true, result);
    }

    @Test
    void testUpdateById() {
        boolean result = t_userServiceImpl.updateById(new TUser());
        Assertions.assertEquals(true, result);
    }

    @Test
    void testUpdate() {
        boolean result = t_userServiceImpl.update(new TUser(), null);
        Assertions.assertEquals(true, result);
    }

    @Test
    void testUpdateBatchById() {
        boolean result = t_userServiceImpl.updateBatchById(List.of(new TUser()), 0);
        Assertions.assertEquals(true, result);
    }

    @Test
    void testGetById() {
        TUser result = t_userServiceImpl.getById(new TUserRole());
        Assertions.assertEquals(new TUser(), result);
    }

    @Test
    void testListByIds() {
        Collection<TUser> result = t_userServiceImpl.listByIds(List.of(null));
        Assertions.assertEquals(List.of(new TUser()), result);
    }

    @Test
    void testListByMap() {
        Collection<TUser> result = t_userServiceImpl.listByMap(Map.of("columnMap", "columnMap"));
        Assertions.assertEquals(List.of(new TUser()), result);
    }

    @Test
    void testGetOne() {
        TUser result = t_userServiceImpl.getOne(null, true);
        Assertions.assertEquals(new TUser(), result);
    }

    @Test
    void testGetMap() {
        Map<String, Object> result = t_userServiceImpl.getMap(null);
        Assertions.assertEquals(Map.of("replaceMeWithExpectedResult", "replaceMeWithExpectedResult"), result);
    }

    @Test
    void testCount() {
        int result = t_userServiceImpl.count(null);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testList() {
        List<TUser> result = t_userServiceImpl.list(null);
        Assertions.assertEquals(List.of(new TUser()), result);
    }

    @Test
    void testPage() {
        IPage<TUser> result = t_userServiceImpl.page(null, null);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testListMaps() {
        List<Map<String, Object>> result = t_userServiceImpl.listMaps(null);
        Assertions.assertEquals(List.of(Map.of("replaceMeWithExpectedResult", "replaceMeWithExpectedResult")), result);
    }

//    @Test
//    void testListObjs() {
//        List<V> result = t_userServiceImpl.listObjs(null, null);
//        Assertions.assertEquals(List.of(null), result);
//    }

    @Test
    void testPageMaps() {
        IPage<Map<String, Object>> result = t_userServiceImpl.pageMaps(null, null);
        Assertions.assertEquals(null, result);
    }
}

//Generated with love by TestMe :) Please raise issues & feature requests at: https://weirddev.com/forum#!/testme