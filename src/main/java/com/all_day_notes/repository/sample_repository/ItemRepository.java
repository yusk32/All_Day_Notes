package com.all_day_notes.repository.sample_repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.all_day_notes.entity.sample_entity.Item;

/*
 * Entityが１つにつき必ず１つのレポジトリが必要になる。
 * レポジトリは、データベース操作を行うために定義されるインターフェース
 * @Repositoryをインターフェースに設定する
 * Spring Data JPAに定義されているJpaRepositoryを継承する(JPA利用時のみ)
 * 用意したいSQLごとにメソッドを作成する
 */


@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {


}
